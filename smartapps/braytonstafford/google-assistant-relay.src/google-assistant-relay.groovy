/**
 *  Google Assistant Relay
 *
 *  Copyright 2018 Brayton Stafford
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Google Assistant Relay",
    namespace: "braytonstafford",
    author: "Brayton Stafford",
    description: "Google Assistant Relay smartapp relays notfications from your devices to the Google Assistant Relay nodejs app hosted on your local network",
    category: "Convenience",
    iconUrl: "https://choreitup.com/wp-content/uploads/2018/11/google-assistant-relay-logo.png",
    iconX2Url: "https://choreitup.com/wp-content/uploads/2018/11/google-assistant-relay-logo@2x.png",
    iconX3Url: "https://choreitup.com/wp-content/uploads/2018/11/google-assistant-relay-logo@3x.png")

    import groovy.json.JsonSlurper
    import groovy.json.JsonBuilder

preferences {
    section("Choose a button") {
        input "thebutton", "capability.button", title: "Test Button", multiple: false, required: true
    }
    section("So much to say") {
	    input "thewords", "string", title: "What to say?", multiple: false, required: true
    }
    
    section("Choose one or more, when...") {
        input "button", "capability.button", title: "Button Pushed", multiple: true, required: false
        input "motion", "capability.motionSensor", title: "Motion Here", multiple: true, required: false
        input "contactOpen", "capability.contactSensor", title: "Contact Opens", multiple: true, required: false
        input "contactClose", "capability.contactSensor", title: "Contact Closes", multiple: true, required: false
        input "acceleration", "capability.accelerationSensor", title: "Acceleration Detected", multiple: true, required: false
        input "switchOn", "capability.switch", title: "Switch Turned On", multiple: true, required: false
        input "switchOff", "capability.switch", title: "Switch Turned Off", multiple: true, required: false
        input "arrivalOf", "capability.presenceSensor", title: "Arrival Of", multiple: true, required: false
        input "departureOf", "capability.presenceSensor", title: "Departure Of", multiple: true, required: false
        input "smokeDetected", "capability.smokeDetector", title: "Smoke Detected", multiple: true, required: false
        input "waterSensor", "capability.waterSensor", title: "Water Sensor Wet", multiple: true, required: false
    }
    section("Send this message (optional, sends standard notification if not specified)") {
	    input "messageText", "string", title: "Message Text", multiple: false, required: false
    }
    section("Google Assistant Relay Host Information") {
	    input "garHost", "string", title: "Google Assistant Relay Hostname or IP Address", multiple: false, required: true
	    input "garPort", "string", title: "Google Assistant Relay Port", multiple: false, required: true
    }
    section("Minimum time between messages (optional, applies to all messages") {
	    input "waitTime", "number", title: "Minutes", multiple: false, required: false
    }
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	subscribe(thebutton, "button", buttonOldHandler)
    subscribe(button, "button", buttonHandler)
    subscribe(motion, "motion", motionHandler)
    subscribe(contactOpen, "contactOpen", contactOpenHandler)
    subscribe(contactClose, "contactClose", contactCloseHandler)
    subscribe(acceleration, "acceleration", accelerationHandler)
    subscribe(switchOn, "switchOn", switchOnHandler)
    subscribe(switchOff, "switchOff", switchOffHandler)
    subscribe(arrivalOf, "arrivalOf", arrivalOfHandler)
    subscribe(departureOf, "departureOf", departureOfHandler)
    subscribe(smokeDetected, "smokeDetected", smokeDetectedHandler)
    subscribe(waterSensor, "waterSensor", waterSensorHandler)
}

def someEventHandler(evt) {
    // returns a list of the values for all switches
    def currSwitches = switchOn.currentSwitch

    def onSwitches = currSwitches.findAll { switchVal ->
        switchVal == "on" ? true : false
    }

    log.debug "${onSwitches.size()} out of ${switchOn.size()} switches are on"
}

def buttonHandler(evt) {
    relayMessage("${evt.getDisplayName()} was ${evt.value}", evt)
}

def motionHandler(evt) {
    relayMessage("Motion detected by ${evt.getDisplayName()}", evt)
}

def contactOpenHandler(evt) {
    relayMessage("${evt.getDisplayName()} was open", evt)
}

def contactCloseHandler(evt) {
    relayMessage("${evt.getDisplayName()} was closed", evt)
}

def accelerationHandler(evt) {
	relayMessage("Movement detected on ${evt.getDisplayName()}", evt)
}

def switchOnHandler(evt) {
    def currSwitches = switchOn.currentSwitch

    def onSwitches = currSwitches.findAll { switchVal ->
        switchVal == "on" ? relayMessage("${currSwitches.getDisplayName()} was turned on", evt) : false
    }
}

def switchOffHandler(evt) {
    def currSwitches = switchOn.currentSwitch

    def onSwitches = currSwitches.findAll { switchVal ->
        switchVal == "off" ? relayMessage("${currSwitches.getDisplayName()} was turned off", evt) : false
    }
}

def arrivalOfHandler(evt) {
	relayMessage("${evt.getDisplayName()} was ${evt.value}", evt)
}

def departureOfHandler(evt) {
	relayMessage("${evt.getDisplayName()} was ${evt.value}", evt)
}

def smokeDetectedHandler(evt) {
	relayMessage("${evt.getDisplayName()} was ${evt.value}", evt)
}

def waterSensorHandler(evt) {
	relayMessage("${evt.getDisplayName()} was ${evt.value}", evt)
}

def relayMessage(message, evt) {
    log.debug "relayMessage called"
    try {
		def myJson = "{ \"command\": \"${message}\",\"broadcast\": true }"

        def headers = [:]
        headers.put("HOST", "$garHost:$garPort")
        headers.put("Content-Type", "application/json")

        //log.debug "The Header is $headers"

        def method = "POST"

        def path = "/assistant"

        try {
            def hubAction = new physicalgraph.device.HubAction(
                [
                    method: method,
                    path: path,
                    body: myJson,
                    headers: headers
                ]
            )

            log.debug hubAction
            sendHubCommand(hubAction)
        }
        catch (Exception e) {
            log.debug "Hit Exception $e on $hubAction"
        }
    } catch (Exception e) {
      log.error "An error occurred while doing things: ${e}"
    }
}

def buttonOldHandler(evt) {
    log.debug "buttonHandler called: $evt"
    if (evt.value == "pushed") {
    log.debug "The Header is $headers"
    try {
		def myJson = "{ \"command\": \"${thewords}\",\"broadcast\": true }"

        def headers = [:]
        headers.put("HOST", "$garHost:$garPort")
        headers.put("Content-Type", "application/json")

        log.debug "The Header is $headers"

        def method = "POST"

        def path = "/assistant"

        try {
            def hubAction = new physicalgraph.device.HubAction(
                [
                    method: method,
                    path: path,
                    body: myJson,
                    headers: headers
                ]
            )

            log.debug hubAction
            sendHubCommand(hubAction)
        }
        catch (Exception e) {
            log.debug "Hit Exception $e on $hubAction"
        }
    } catch (Exception e) {
      log.error "An error occurred while doing things: ${e}"
    }
    } else if (evt.value == "held") {
    	log.debug "stop holding the button down!!!"
    }
}