package notification_pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

const val TOKEN = "cFJdjC1UT16W34KYRzyCeF:APA91bGtQ9ITEz6CodE_tpQSqIXPyaGlxiSoyK5rtRKh-Vzuy_MvUsuf0RWy4wTt_x8StxIIP-q9NVuatGjrXFQnYNVwNOJpamTAEpUBAyk5jPuje4An7IAMgxre7nVHbO3X2N45iwe8"

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action" , "NEW_POST")
        .putData("content" , """{
          "id": 2,
          "title": "New post",
          "date": "22.12.22",
          "content": "By default, the notification's text content is truncated to fit one line. If you want your notification to be longer, you can enable an expandable notification by adding a style template with setStyle(). For example, the following code creates a larger text area:",
          "likes": 0,
          "shares" : 0 ,
          "shows": 0,
          "isLiked": "true"
        }
            
        """.trimIndent())
        .setToken(TOKEN)
        .build()
    FirebaseMessaging.getInstance().send(message)

}