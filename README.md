### Lime Mobile Onsite Challenge
**Goal**
Serve up a lightweight Reddit feed for travelers or photographers on the go! A PM has given you requirements for the UI while we also want to ensure that the app is scalable as more engineers begin working on the app. 
Follow the requirements below to create an MVP for our Reddit app.


**Requirements**

UI Requirements
Only show posts that contain an image
Display the title, image, author, and any other useful post information per card.
Smooth Scrolling Feed

**And 1 of the following features:**

Search a subreddit
Post detail view
Pagination


**Eng Requirements**

Clean & Performant Code
Simple App Architecture
Demonstrate knowledge of most libraries/components used


**Networking**

Base URL: https://reddit.com/

**Feed: **

GET r/<name_of_subreddit>
	Append: /top.json to get the top posts (often more image related posts)
Example: https://reddit.com/r/travel/top.json

Individual Post: Permalink is included in the individual via the feed request (eg: "permalink": "/r/travel/comments/9af10v/just_visited_mostar_bosnia_and_herzegovina/")
Example: https://www.reddit.com/r/travel/comments/9af10v/just_visited_mostar_bosnia_and_herzegovina.json
[IMPORTANT] Response Body Encoding
For legacy reasons, all JSON response bodies currently have <, >, and & replaced with &lt;, &gt;, and &amp;, respectively. If you wish to opt out of this behaviour, add a raw_json=1 parameter to your request.

### Solution

**Tech Stack**
- Kotlin
- Jetpack Compose
- MVVM and clean architecture.
- Dagger/Hilt
- Coil
- Retrofit
- Flows + Coroutines
