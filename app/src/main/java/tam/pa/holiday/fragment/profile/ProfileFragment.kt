package tam.pa.holiday.fragment.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import tam.pa.holiday.R
import tam.pa.holiday.model.profile.DataProfile
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), IViewProfile{
    lateinit var iViewProfile: IViewProfile
    lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        iViewProfile = this
        presenter = ProfilePresenter(iViewProfile, activity)
        presenter.onGetProfile()
        return view
    }

    override fun onGetData(data: DataProfile?) {
        Picasso.get().load(data?.avatar)
            .fit()
            .into(ivProfile)
        tvUsername.text = data?.username
        tvFullname.text = "("+data?.fullname+")"
        tvEmail.text = data?.email
        tvTelp.text = data?.phone
    }

    override fun onFailur(msg: String) {
        Log.d("errorPresenter", msg)
    }
}