package com.example.practiceapp

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Camera
import android.hardware.camera2.CameraManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.practiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var cameraFlash  = false
    var flashOn  = false
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       cameraFlash = packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)

        binding.off.setOnClickListener{
            if(cameraFlash)
            {
                if(flashOn)
                {
                    flashOn = false
                   binding.off.setImageResource(R.drawable.off)
                    flashlightOff()
                }
                else
                {
                    flashOn = true
                    binding.off.setImageResource(R.drawable.on)
                    flashlightOn()
                }
            }



        }


    }

    private fun flashlightOn() {

        var CameraManager : CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        var cameraId : String

     try {
         cameraId = CameraManager.cameraIdList[0]
         CameraManager.setTorchMode(cameraId, true)
     }
     catch(e : Exception){}

    }

    private fun flashlightOff() {

        var CameraManager : CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        var cameraId : String

        try {
            cameraId = CameraManager.cameraIdList[0]
            CameraManager.setTorchMode(cameraId, false)
        }
        catch(e : Exception){}
    }
}