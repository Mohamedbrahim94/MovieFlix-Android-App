package com.example.movieflix.movieflex.movflix.base

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel


abstract class BaseActivity<vm : ViewModel, db : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewModel: vm
    lateinit var binding: db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = initializeViewModel()

    }
        abstract fun getLayoutId(): Int
        abstract fun initializeViewModel(): vm

        open fun showMessage(message: String?, posActionName: String?): AlertDialog? {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
            builder.setPositiveButton(
                posActionName
            ) { dialog, which -> dialog.dismiss() }
            return builder.show()
        }

        open fun showMessage(
            message: String?,
            posActionName: String?,
            postiveAction: DialogInterface.OnClickListener,
        ): AlertDialog? {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
            builder.setPositiveButton(
                posActionName, postiveAction
            )
            return builder.show()
        }

        open fun showMessage(message: Int, posActionName: Int): AlertDialog? {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
            builder.setPositiveButton(
                posActionName
            ) { dialog, which -> dialog.dismiss() }
            return builder.show()
        }

        open fun showMessage(
            message: String?, posActionName: String?,
            onClickListener: DialogInterface.OnClickListener?,
            isCancelable: Boolean,
        ): AlertDialog? {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
            builder.setPositiveButton(posActionName, onClickListener)
            builder.setCancelable(isCancelable)
            return builder.show()
        }

        open fun showMessage(
            message: String?, posActionName: String?,
            onPosClick: DialogInterface.OnClickListener?,
            negativeText: String?,
            onNegativeClick: DialogInterface.OnClickListener?,
            isCancelable: Boolean,
        ): AlertDialog? {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
            builder.setPositiveButton(posActionName, onPosClick)
            builder.setNegativeButton(negativeText, onNegativeClick)
            builder.setCancelable(isCancelable)
            return builder.show()
        }

        open fun showMessage(
            message: Int, posActionName: Int,
            onClickListener: DialogInterface.OnClickListener?,
            isCancelable: Boolean,
        ): AlertDialog? {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
            builder.setPositiveButton(posActionName, onClickListener)
            builder.setCancelable(isCancelable)
            return builder.show()
        }

        open fun showMessage(
            message: Int, posActionName: Int,
            onPosClick: DialogInterface.OnClickListener?,
            negativeText: Int,
            onNegativeClick: DialogInterface.OnClickListener?,
            isCancelable: Boolean,
        ): AlertDialog? {
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
            builder.setPositiveButton(posActionName, onPosClick)
            builder.setNegativeButton(negativeText, onNegativeClick)
            builder.setCancelable(isCancelable)
            return builder.show()
        }

        fun showToast(toastMessage: String) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()

        }

    }
