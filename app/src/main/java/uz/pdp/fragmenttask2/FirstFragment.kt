package uz.pdp.kotlinfrag

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.pdp.fragmenttask2.R
import uz.pdp.fragmenttask2.User
import kotlin.String as String

class FirstFragment : Fragment() {
    var listener : FirstListener? = null
    lateinit var root: View
    lateinit var first_btn : Button
    lateinit var first_tv : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_first, container, false)
        first_tv = root.findViewById(R.id.first_tv)
        first_btn = root.findViewById(R.id.first_btn)

        first_btn.setOnClickListener {
            val user = User("Diyor", 20)
            listener!!.onFirstSend(user)
        }

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstListener) {
            context
        } else {
            throw RuntimeException("$context must implement First Listener")
        }

    }
    fun updateFirstText(s: User) {
        first_tv.setText("name = ${s.name} age = ${s.age}")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface FirstListener {
        fun onFirstSend(s: User)
    }

}