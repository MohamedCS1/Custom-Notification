package com.example.customnotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayofimages = arrayListOf<Int>()

        arrayofimages.add(R.drawable.img0)
        arrayofimages.add(R.drawable.img1)
        arrayofimages.add(R.drawable.img2)
        arrayofimages.add(R.drawable.img3)
        arrayofimages.add(R.drawable.img4)
        arrayofimages.add(R.drawable.img5)
        arrayofimages.add(R.drawable.img6)
        arrayofimages.add(R.drawable.img7)
        arrayofimages.add(R.drawable.img8)
        arrayofimages.add(R.drawable.img9)

        var counter = 0

        val bu_push = findViewById<Button>(R.id.bu_notification)
         bu_push.setOnClickListener {
             counter++
             if (counter == 10)
             {
                 counter = 0
             }
             push_notification(arrayofimages[counter])
         }
    }
    var c = 0
    fun push_notification(img: Int)
    {

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val notificationchannel = NotificationChannel("CHA1" ,"NotificationChannel" ,NotificationManager.IMPORTANCE_HIGH)

            notificationManager.createNotificationChannel(notificationchannel)
        }
        val notificationBuild = NotificationCompat.Builder(this ,"CHA1")

        notificationBuild.setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContent(getremoteviews(img))
            .color = Color.BLACK

        notificationManager.notify(c++ ,notificationBuild.build())

    }

    fun getremoteviews(img:Int):RemoteViews
    {


        val rv = RemoteViews(packageName ,R.layout.card_notification)
        rv.setImageViewResource(R.id.image_notification ,img)
        rv.setTextViewText(R.id.notification_title ,"Title")
        rv.setTextViewText(R.id.notification_des ,"Description Description Description Description Description Description Description Description Description Description Description")
        return rv
    }
}