package notification_pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val token = "chKbXqDvSjyAj5HJZG8cQp:APA91bFrfxXIRxJLl5viFPF4ZAPwcDb9XMDN-GutYhiaQFEJIZJ3bnuUiaktMx0cLShxtS0hT3xGw-eBLI1-StDKHelm76IOBIR_zPmWnJkpsD5JmfQEOJzGJZNL1W0RvSs0D7jkvwBZ"
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "like")
        .putData(
            "content", """
            "userId": 1 , 
            "userName": "Vasiliy",
            "postId": 2 ,
            "postAuthor": "Netology"
        """.trimIndent()
        )
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}