package hr.ferit.krunoslavkazalicki.myworkout3

import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val usernameTextView = view.findViewById<TextView>(R.id.username_tv)
        val numberOfWokroutsTextView = view.findViewById<TextView>(R.id.numOfWorkouts_tv)
        val weightEditText = view.findViewById<EditText>(R.id.weight_etnum)
        val heightEditText = view.findViewById<EditText>(R.id.height_etnum)
        val genderRadioGroup = view.findViewById<RadioGroup>(R.id.gender_rg)
        val ageEditText = view.findViewById<EditText>(R.id.age_etnum)
        val bodyFatPercentageEditText = view.findViewById<EditText>(R.id.bodyFatPercentage_etnum)
        val musclePercentageEditText = view.findViewById<EditText>(R.id.musclePercentage_etnum)
        val caloriesIntakeEditText = view.findViewById<EditText>(R.id.caloriesIntake_etnum)
        val saveChangesButton = view.findViewById<Button>(R.id.saveChanges_btn)

        var username = usernameTextView.text.toString()
        var numberOfWorkouts = numberOfWokroutsTextView.text.toString().toInt()
        var weight = weightEditText.text.toString().toFloat()
        var height = heightEditText.text.toString().toFloat()
        var gender = "unset"

        genderRadioGroup.setOnCheckedChangeListener { group, checkedId ->
             gender = when(checkedId){
                R.id.male_rb -> "male"
                R.id.female_rb -> "female"
                else -> "unset"
            }
        }

        var age = ageEditText.text.toString().toInt()
        var bodyFatPercentage = bodyFatPercentageEditText.text.toString().toFloat()
        var musclePercentage = musclePercentageEditText.text.toString().toFloat()
        var caloriesIntake = caloriesIntakeEditText.text.toString().toFloat()

        saveChangesButton.setOnClickListener(){}

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}
