package hr.ferit.krunoslavkazalicki.myworkout3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup


class LogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_log, container, false)

        val repsEditText = view.findViewById<EditText>(R.id.reps_etnum)
        val setsEditText = view.findViewById<EditText>(R.id.sets_etnum)
        val durationEditText = view.findViewById<EditText>(R.id.duration_etnum)
        val intensityEditText = view.findViewById<EditText>(R.id.intensity_etnum)
        val muscleGroupRadioGroup = view.findViewById<RadioGroup>(R.id.muscleGroup_rg)
        val logSetWorkoutButton = view.findViewById<Button>(R.id.logSetWorkout_btn)
        val logTimedWorkoutButton = view.findViewById<Button>(R.id.logTimedWorkout_btn)

        var reps = repsEditText.text.toString().toInt()
        var sets = setsEditText.text.toString().toInt()
        var duration = durationEditText.text.toString().toInt()
        var intensity = intensityEditText.text.toString().toInt()
        var muscleGroup = "unset"

        muscleGroupRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            muscleGroup = when(checkedId){
                R.id.arms_rb -> "arms"
                R.id.legs_rb -> "legs"
                R.id.upperBody_rb -> "upper body"
                R.id.lowerBody_rb -> "lower body"
                else -> "unset"
            }
        }

        logSetWorkoutButton.setOnClickListener(){

        }

        logTimedWorkoutButton.setOnClickListener(){

        }

        return view
    }

    fun calculateSetEffort(reps: Int, sets: Int, muscleGroup: String):Float{
        var effort = 0
        effort = when(muscleGroup){
            "arms" -> (1/3*weight*reps*sets)
            "legs" -> (1.5/3*weight*reps*sets)
            "upper body" -> (2/3*weight*reps*sets)
            "lower body" -> (2/3*weight*reps*sets)
            else -> (1/3*weight*reps*sets)
        }
        return effort
    }


}