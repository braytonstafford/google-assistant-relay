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
    page(name: "homePage")
    page(name: "scheduledPage")
}

def homePage(params) {
    def hrefParams = [
        foo: "bar",
        someKey: "someVal"
    ]

    dynamicPage(name: "homePage", title: "Google Assistance Relay Notification Setup", install: true, uninstall: true) {
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
        section("Google Assistant Relay Host Information") {
            input "garHost", "string", title: "Google Assistant Relay Hostname or IP Address", multiple: false, required: true
            input "garPort", "number", title: "Google Assistant Relay Port", multiple: false, required: true
            input "garUser", "string", title: "Username from Google Assistant Relay Config", multiple: false, required: false
        }
        section("Notification Schedule") {
            href(name: "Notification Schedules",
                 title: "Schedule Notifications",
                 description: "Schedule Notifications by Device Type",
                 required: false,
                 page: "scheduledPage",
                 params: hrefParams)
        }
        section("Set for specific mode(s)") {
            mode(title: "Set for specific mode(s)")
        }
    }
}

def scheduledPage(params) {
    dynamicPage(name: "scheduledPage", title: "Schedule Notifications by Device Type:") {
        section("Button Sensors Schedule") {
            input "buttonSensorsScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "buttonSensorsFromTime", "time", title: "From Time: ", required: false
            input "buttonSensorsToTime", "time", title: "To Time: ", required: false
        }
        section("Motion Sensors Schedule") {
            input "motionSensorsScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "motionSensorsFromTime", "time", title: "From Time: ", required: false
            input "motionSensorsToTime", "time", title: "To Time: ", required: false
        }
        section("Contacts - Opened Schedule") {
            input "contactsOpenedScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "contactsOpenedFromTime", "time", title: "From Time: ", required: false
            input "contactsOpenedToTime", "time", title: "To Time: ", required: false
        }
        section("Contacts - Closed Schedule") {
            input "contactsClosedScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "contactsClosedFromTime", "time", title: "From Time: ", required: false
            input "contactsClosedToTime", "time", title: "To Time: ", required: false
        }
        section("Acceleration Sensors Schedule") {
            input "accelerationSensorsScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "accelerationSensorsFromTime", "time", title: "From Time: ", required: false
            input "accelerationSensorsToTime", "time", title: "To Time: ", required: false
        }
        section("Switches On Schedule") {
            input "switchesOnScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "switchesOnFromTime", "time", title: "From Time: ", required: false
            input "switchesOnToTime", "time", title: "To Time: ", required: false
        }
        section("Switches Off Schedule") {
            input "switchesOffScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "switchesOffFromTime", "time", title: "From Time: ", required: false
            input "switchesOffToTime", "time", title: "To Time: ", required: false
        }
        section("Arrival Of Schedule") {
            input "arrivalOfScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "arrivalOfFromTime", "time", title: "From Time: ", required: false
            input "arrivalOfToTime", "time", title: "To Time: ", required: false
        }
        section("Departure Of Schedule") {
            input "departureOfScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "departureOfFromTime", "time", title: "From Time: ", required: false
            input "departureOfToTime", "time", title: "To Time: ", required: false
        }
        section("Smoke Detected Schedule") {
            input "smokeDetectedScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "smokeDetectedFromTime", "time", title: "From Time: ", required: false
            input "smokeDetectedToTime", "time", title: "To Time: ", required: false
        }
        section("Water Sensors Schedule") {
            input "waterSensorsScheduled", "enum", title: "Enable notfication schedule?", options: ["Yes", "No"], required: false, defaultValue: "No"
            input "waterSensorsFromTime", "time", title: "From Time: ", required: false
            input "waterSensorsToTime", "time", title: "To Time: ", required: false
        }
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
		def myJson = "{ \"user\": \"${garUser}\",\"command\": \"${message}\",\"broadcast\": true }"

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

def between(fromTime, toTime) {
    return timeOfDayIsBetween(fromTime, toTime, new Date(), location.timeZone)
}

def buttonHandler(evt) {
    if (buttonSensorsScheduled == "Yes" && buttonSensorsFromTime && buttonSensorsToTime) {
    log.debug "between(buttonSensorsFromTime, buttonSensorsToTime) ${between(buttonSensorsFromTime, buttonSensorsToTime)}"
        if (between(buttonSensorsFromTime, buttonSensorsToTime)) {
            relayMessage("${evt.getDevice()} was pushed", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} was pushed", evt)
    }
}

def motionHandler(evt) {
    if (motionSensorsScheduled == "Yes" && motionSensorsFromTime && motionSensorsToTime) {
        if (between(motionSensorsFromTime, motionSensorsToTime)) {
            relayMessage("Motion detected at ${evt.getDevice()}", evt)
        }
    } else {
        relayMessage("Motion detected at ${evt.getDevice()}", evt)
    }
}

def contactOpenHandler(evt) {
    if (contactsOpenedScheduled == "Yes" && contactsOpenedFromTime && contactsOpenedToTime) {
        if (between(contactsOpenedFromTime, contactsOpenedToTime)) {
            relayMessage("${evt.getDevice()} was open", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} was open", evt)
    }
}

def contactCloseHandler(evt) {
    if (contactsClosedScheduled == "Yes" && contactsClosedFromTime && contactsClosedToTime) {
        if (between(contactsClosedFromTime, contactsClosedToTime)) {
            relayMessage("${evt.getDevice()} was closed", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} was closed", evt)
    }
}

def accelerationHandler(evt) {
    if (accelerationSensorsScheduled == "Yes" && accelerationSensorsFromTime && accelerationSensorsToTime) {
        if (between(accelerationSensorsFromTime, accelerationSensorsToTime)) {
            relayMessage("Movement detected by ${evt.getDevice()}", evt)
        }
    } else {
        relayMessage("Movement detected by ${evt.getDevice()}", evt)
    }
}

def switchOnHandler(evt) {
    if (switchesOnScheduled == "Yes" && switchesOnFromTime && switchesOnToTime) {
        if (between(switchesOnFromTime, switchesOnToTime)) {
	        relayMessage("${evt.getDevice()} was turned on", evt)
        }
    } else {
	    relayMessage("${evt.getDevice()} was turned on", evt)
    }
}

def switchOffHandler(evt) {
    if (switchesOffScheduled == "Yes" && switchesOffFromTime && switchesOffToTime) {
        if (between(switchesOffFromTime, switchesOffToTime)) {
            relayMessage("${evt.getDevice()} was turned off", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} was turned off", evt)
    }
}

def arrivalOfHandler(evt) {
    if (arrivalOfScheduled == "Yes" && arrivalOfFromTime && arrivalOfToTime) {
        if (between(arrivalOfFromTime, arrivalOfToTime)) {
            relayMessage("${evt.getDevice()} has arrived", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} has arrived", evt)
    }
}

def departureOfHandler(evt) {
    if (departureOfScheduled == "Yes" && departureOfFromTime && departureOfToTime) {
        if (between(departureOfFromTime, departureOfToTime)) {
            relayMessage("${evt.getDevice()} has departed", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} has departed", evt)
    }
}

def smokeDetectedHandler(evt) {
    if (smokeDetectedScheduled == "Yes" && smokeDetectedFromTime && smokeDetectedToTime) {
        if (between(smokeDetectedFromTime, smokeDetectedToTime)) {
            relayMessage("${evt.getDevice()} has detected smoke!", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} has detected smoke!", evt)
    }
}

def waterSensorHandler(evt) {
    if (waterSensorsScheduled == "Yes" && waterSensorsFromTime && waterSensorsToTime) {
        if (between(waterSensorsFromTime, waterSensorsToTime)) {
            relayMessage("${evt.getDevice()} has detected water!", evt)
        }
    } else {
        relayMessage("${evt.getDevice()} has detected water!", evt)
    }
}
