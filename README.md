# Google Assistant Relay SmartApp and Speech Device Handler
### for use with Google Assistant Relay v2

***Important: The smartapp and device handler will only work with a functioning Google Assistant Relay v2 server. For information on the Google Assistant Relay visit the [Google Assistant Relay v2 SmartThing's forum post](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications).***

**SmartApp:** Used to broadcast SmartThings device state changes to your Google Home using the [Google Assistant Relay v2](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications). The smartapp listens for smartthings device events and POST's a JSON message to the Google Assistant Relay v2 server when a device event is triggered.

**Device Handler:** Can be used in conjunction with 3rd party tools (ie. WebCoRE) to send custom notifications to your [Google Assistant Relay v2](https://community.smartthings.com/t/release-google-assistant-relay-v2-0-google-home-audio-notifications) server.

You do not need to install both the smartapp and device handler. If you only want device notifications the smartapp will do that autonomous from the device handler.  The device handler is handy to have if you are integrating other smartapps or 3rd party applications that need a smartthings device to perform an action. Currently the device handler only supports the speech synthesis capability.

# Install Instructions: Installing the SmartApp on the SmartThings hub and in the SmartThings App
## STEP 1: Install the SmartApp on the Hub
**Method 1**

Login to your SmartThings API account
[https://account.smartthings.com/](https://account.smartthings.com/)

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
[https://account.smartthings.com/](https://account.smartthings.com/)

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

# Install Instructions: Installing the Device Handler on the SmartThings hub

## STEP 1: Install the Device Handler on the Hub
**Method 1**

Login to your SmartThings API account
[https://account.smartthings.com/](https://account.smartthings.com/)

Click My My Device Handlers

Click Settings

Click Add new repository and fill in the fields with these exact values and click Save:
  Owner: braytonstafford
  Name: google-assistant-relay
  Branch: master

Click Update from Repo and select google-assistant-relay (master)

In the right side panel under New (only in GitHub) check the box next to smartapps/braytonstafford/google-assistant-relay-speech.src/google-assistant-relay-speech.groovy

Check the box for Publish

Click Execute update

**Method 2**

Login to your SmartThings API account
[https://account.smartthings.com/](https://account.smartthings.com/)

Click My Device Handlers

Click Create New Device Handler

Click From Code

Copy and Paste the code from [here](https://raw.githubusercontent.com/braytonstafford/google-assistant-relay/master/devicetypes/braytonstafford/google-assistant-relay-speech.src/google-assistant-relay-speech.groovy) into the code editor

Click Create

Click Publish -> For Me

## STEP 2: Create the Device on the Hub

Login to your SmartThings API account
[https://account.smartthings.com/](https://account.smartthings.com/)

Click My Devices

Click New Device

Enter these values in the fields and click Create:
* Name: Google Assistant Relay Speech
* Label: Google Assistant Relay Speech
* Device Network Id: GoogleAssistantRelaySpeech1
* Type: Google Assistant Relay Speech
* Version: Published
* Location: [YOUR LOCATION]
* Hub: [YOUR HUB]
* Group: Location: [YOUR GROUP] (if applicable)

## STEP 3: Setup the Device in the SmartThings app
Open the SmartThings App

Go to My Home

Under the Things tab click the Google Assistant Relay Speech device

Click the settings wheel in the top right

Enter the Google Assistant Relay Hostname/IP Address and Port

Click Save

Your device is now setup in the SmartThings app. This device has the speech synthesis capability which can be used with WebCoRE to send custom phrases to your Google Assistant Relay

### Follow me on the web

* https://braytonstafford.com/

### Throw me a bone
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=YLWNGCR4CWZU6&source=url" target="_blank"><img src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" alt="Donate" width="163"/></a>

<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=YLWNGCR4CWZU6&source=url" target="_blank"><img src="https://imgur.com/825moem.png" alt="Donate QR Code"/></a>
