package com.thirstysheep.mytest

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.util.Log
import com.thirstysheep.requestpermission.RequestPermission
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import com.thirstysheep.requestpermission.PermissionCallback
import com.thirstysheep.requestpermission.PermissionItem
import java.util.*


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener {
            Log.i(TAG,"HelloWorld")
            toast("HelloWorld")

/*            RequestPermission.create(this)
                    .checkMutiPermission(object : PermissionCallback {
                        override fun onClose() {
                            Log.i(TAG, "onClose")
                            toast("用户关闭权限申请")
                        }

                        override fun onFinish() {
                            toast("所有权限申请完成")
                        }

                        override fun onDeny(permission: String, position: Int) {
                            Log.i(TAG, "onDeny")
                        }

                        override fun onGuarantee(permission: String, position: Int) {
                            Log.i(TAG, "onGuarantee")
                        }
                    })*/

            val permissionItems = ArrayList<PermissionItem>()

            permissionItems.add(PermissionItem(Manifest.permission.CAMERA, "照相机", R.drawable.permission_ic_camera))
            permissionItems.add(PermissionItem(Manifest.permission.ACCESS_FINE_LOCATION, "定位", R.drawable.permission_ic_location))


            RequestPermission.create(this)
                    .permissions(permissionItems)
                    .filterColor(ResourcesCompat.getColor(resources, R.color.colorPrimaryDark, theme))//图标的颜色
                    .style(R.style.PermissionBlueStyle)
                    .checkMutiPermission(object : PermissionCallback {
                        override fun onClose() {
                            Log.i(TAG, "onClose")
                            toast("用户关闭权限申请")
                        }

                        override fun onFinish() {
                            toast("所有权限申请完成")
                        }

                        override fun onDeny(permission: String, position: Int) {
                            Log.i(TAG, "onDeny")
                        }

                        override fun onGuarantee(permission: String, position: Int) {
                            Log.i(TAG, "onGuarantee")
                        }
                    })


        }
    }
}
