# SmartThings SmartApp for Google Assistant Relay v2

SmartApp to broadcast SmartThings device state changes to your Google Home using the [Google Assistant Relay v2](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications).

This smartapp only works if you have the Google Assistant Relay Notifications setup on the same network your smartthings hub is connected to. For imformation and support for the Google Assistant Relay visit the [Google Assistant Relay v2 SmartThing's forum post.](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications) 

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

In the right side panel under New (only in GitHub) check the box next to smartapps/braytonstafford/google-assistant-relay.src/google-assistant-relay-notifications.groovy

Check the box for Publish

Click Execute update

**Method 2**

Visit this [https://raw.githubusercontent.com/braytonstafford/google-assistant-relay/master/smartapps/braytonstafford/google-assistant-relay.src/google-assistant-relay-notifications.groovy](https://raw.githubusercontent.com/braytonstafford/google-assistant-relay/master/smartapps/braytonstafford/google-assistant-relay.src/google-assistant-relay-notifications.groovy) and copy the entire contents.

Login to your SmartThings API account
[https://graph-na02-useast1.api.smartthings.com/ide/apps](https://graph-na02-useast1.api.smartthings.com/ide/apps)

Click My SmartApps

Click New SmartApp

Click From Code

Paste the code from [here](https://raw.githubusercontent.com/braytonstafford/google-assistant-relay/master/smartapps/braytonstafford/google-assistant-relay.src/google-assistant-relay-notifications.groovy)

Click Create

Click Publish -> For Me


## STEP 2: Setup the SmartThings Mobile App
Open the SmartThings App

Go to the Marketplace

Click SmartApps

Click My Apps

Click Google Assistant Relay

Choose the devices you want to recieve notifications when their state changes.

Add an optional custom message

Fill in the Google Assistant Relay Hostname or IP Address

Fill in the Google Assistant Relay Port

Optionally you can choose a duration in minutes to delay notfications between events.

Click Save

You should now hear broadcasts to your Google Home when the selected devices' state changes.

**Follow me on the web**

* https://braytonstafford.com/
