/**
 *  Google Assistant Relay Notifications
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
    name: "Google Assistant Relay Notifications",
    namespace: "braytonstafford",
    author: "Brayton Stafford",
    description: "Google Assistant Relay Notifications smartapp relays notfications from your devices to the Google Assistant Relay nodejs app hosted on your local network",
    category: "Convenience",
    iconUrl: "https://imgur.com/Vg5WuR3.png",
    iconX2Url: "https://imgur.com/ddFjr32.png",
    iconX3Url: "https://imgur.com/sCjNsRS.png")

preferences {
    section("Choose one or more, when...") {
        input "buttonSensors", "capability.button", title: "Button Pushed", multiple: true, required: false
        input "motionSensors", "capability.motionSensor", title: "Motion Here", multiple: true, required: false
        input "contactsOpened", "capability.contactSensor", title: "Contact Opens", multiple: true, required: false
        input "contactsClosed", "capability.contactSensor", title: "Contact Closes", multiple: true, required: false
        input "accelerationSensors", "capability.accelerationSensor", title: "Acceleration Detected", multiple: true, required: false
        input "switchesOn", "capability.switch", title: "Switch Turned On", multiple: true, required: false
        input "switchesOff", "capability.switch", title: "Switch Turned Off", multiple: true, required: false
        input "arrivalOf", "capability.presenceSensor", title: "Arrival Of", multiple: true, required: false
        input "departureOf", "capability.presenceSensor", title: "Departure Of", multiple: true, required: false
        input "smokeDetected", "capability.smokeDetector", title: "Smoke Detected", multiple: true, required: false
        input "waterSensors", "capability.waterSensor", title: "Water Sensor Wet", multiple: true, required: false
    }
    /*section("Send this message (optional, sends standard notification if not specified)") {
	    input "messageText", "string", title: "Message Text", multiple: false, required: false
    }*/
    section("Google Assistant Relay Host Information") {
	    input "garHost", "string", title: "Google Assistant Relay Hostname or IP Address", multiple: false, required: true
	    input "garPort", "number", title: "Google Assistant Relay Port", multiple: false, required: true
        input "garUser", "string", title: "Username from Google Assistant Relay Config", multiple: false, required: true
    }
    /*section("Minimum time between messages (optional, applies to all messages") {
	    input "waitTime", "number", title: "Minutes", multiple: false, required: false
    }*/
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
    subscribe(buttonSensors, "button.pushed", buttonHandler)
    subscribe(motionSensors, "motion.active", motionHandler)
    subscribe(contactsOpened, "contact.open", contactOpenHandler)
    subscribe(contactsClosed, "contact.closed", contactCloseHandler)
    subscribe(accelerationSensors, "acceleration.active", accelerationHandler)
    subscribe(switchesOn, "switch.on", switchOnHandler)
    subscribe(switchesOff, "switch.off", switchOffHandler)
    subscribe(arrivalOf, "presence.present", arrivalOfHandler)
    subscribe(departureOf, "presence.notPresent", departureOfHandler)
    subscribe(smokeDetected, "smoke.detected", smokeDetectedHandler)
    subscribe(waterSensors, "water.wet", waterSensorHandler)
}

def relayMessage(message, evt) {
    try {
		def myJson = "{ \"user\": \"${garUser}\",\"command\": \"${message}\",\"broadcast\": false }"

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

            // log.debug hubAction
            sendHubCommand(hubAction)
        }
        catch (Exception e) {
            log.error "Hit Exception $e on $hubAction"
        }
    } catch (Exception e) {
      log.error "An error occurred while doing things: ${e}"
    }
}

def buttonHandler(evt) {
    relayMessage("${evt.getDevice()} was pushed", evt)
}

def motionHandler(evt) {
    relayMessage("Motion detected at ${evt.getDevice()}", evt)
}

def contactOpenHandler(evt) {
    relayMessage("${evt.getDevice()} was open", evt)
}

def contactCloseHandler(evt) {
    relayMessage("${evt.getDevice()} was closed", evt)
}

def accelerationHandler(evt) {
	relayMessage("Movement detected by ${evt.getDevice()}", evt)
}

def switchOnHandler(evt) {
	relayMessage("${evt.getDevice()} was turned on", evt)
}

def switchOffHandler(evt) {
	relayMessage("${evt.getDevice()} was turned off", evt)
}

def arrivalOfHandler(evt) {
	relayMessage("${evt.getDevice()} has arrived", evt)
}

def departureOfHandler(evt) {
	relayMessage("${evt.getDevice()} has departed", evt)
}

def smokeDetectedHandler(evt) {
	relayMessage("${evt.getDevice()} has detected smoke!", evt)
}

def waterSensorHandler(evt) {
	relayMessage("${evt.getDevice()} has detected water!", evt)
}
