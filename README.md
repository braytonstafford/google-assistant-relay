# SmartThings SmartApp for Google Assistant Relay v2

SmartApp to broadcast SmartThings device state changes to your Google Home using the [Google Assistant Relay v2](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications).

This smartapp will only work with a functioning Google Assistant Relay v2 server. For imformation and support for the Google Assistant Relay visit the [Google Assistant Relay v2 SmartThing's forum post.](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications) 

# Install Instructions
## STEP 1: Install the SmartApp
**Method 1**

Login to your SmartThings API account
[https://graph-na02-useast1.api.smartthings.com/ide/apps](https://graph-na02-useast1.api.smartthings.com/ide/apps)

Click My SmartApps

Click Settings

Click Add new repository and fill in the fields with these exact values and click Save:
  Owner: braytonstafford
  Name: google-assistant-relay
  Branch: master

# Google Assistant Relay Notifications SmartApp for use with Google Assistant Relay v2

A SmartApp to broadcast SmartThings device state changes to your Google Home using the [Google Assistant Relay v2](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications). The smartapp listens for smartthings device events and POST's a JSON message to the Google Assistant Relay v2 server when a device event is triggered.

This smartapp will only work with a functioning Google Assistant Relay v2 server. For information on the Google Assistant Relay visit the [Google Assistant Relay v2 SmartThing's forum post.](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications) 

# Features
### Device / Capability

* Button / pushed
* Motion Sensor / active
* Contact / opened
* Contact / closed
* Acceleration Sensor / movement
* Switch / on
* Switch / off
* Presence Sensor / present
* Presence Sensor / not present
* Smoke Sensor / detected
* Water Sensor / wet

# Install Instructions
## STEP 1: Install the SmartApp
**Method 1**

Login to your SmartThings API account
[https://graph-na02-useast1.api.smartthings.com/ide/apps](https://graph-na02-useast1.api.smartthings.com/ide/apps)

Click My SmartApps

Click Settings

Click Add new repository and fill in the fields with these exact values and click Save:
  Owner: braytonstafford
  Name: google-assistant-relay
  Branch: master

Click Update from Repo and select google-assistant-relay (master)

In the right side panel under New (only in GitHub) check the box next to smartapps/braytonstafford/google-assistant-relay-notifications.src/google-assistant-relay-notifications.groovy

Check the box for Publish

Click Execute update

**Method 2**

Login to your SmartThings API account
[https://graph-na02-useast1.api.smartthings.com/ide/apps](https://graph-na02-useast1.api.smartthings.com/ide/apps)

Click My SmartApps

Click New SmartApp

Click From Code

Copy and Paste the code from [here](https://raw.githubusercontent.com/braytonstafford/google-assistant-relay/master/smartapps/braytonstafford/google-assistant-relay-notifications.src/google-assistant-relay-notifications.groovy) into the code editor

Click Create

Click Publish -> For Me


## STEP 2: Setup the SmartThings Mobile App
Open the SmartThings App

Go to the Marketplace

Click SmartApps

Click My Apps

Click Google Assistant Relay

Choose the devices you want to receive notifications when their state changes.

Fill in the Google Assistant Relay Hostname or IP Address

Fill in the Google Assistant Relay Port

Click Save

You should now hear broadcasts to your Google Home when the selected devices' state changes.



### Tested:
* Button / pushed
* Motion Sensor / active
* Contact / opened
* Contact / closed
* Acceleration Sensor / movement
* Switch / on
* Switch / off


### Follow me on the web

* https://braytonstafford.com/
