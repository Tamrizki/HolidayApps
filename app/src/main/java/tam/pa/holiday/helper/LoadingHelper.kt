package tam.pa.holiday.helper

import android.app.ProgressDialog
import android.content.Context

class LoadingHelper(context: Context?) {
    val progressDialog = ProgressDialog(context)
    fun onStart(){
        progressDialog.setMessage("Loading....")
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.show()
    }
    fun onStop(){
        progressDialog.dismiss()
    }
}