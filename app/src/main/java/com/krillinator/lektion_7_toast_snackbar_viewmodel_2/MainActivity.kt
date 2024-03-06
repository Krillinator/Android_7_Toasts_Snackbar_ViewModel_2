package com.krillinator.lektion_7_toast_snackbar_viewmodel_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.krillinator.lektion_7_toast_snackbar_viewmodel_2.databinding.ActivityMainBinding
import com.krillinator.lektion_7_toast_snackbar_viewmodel_2.models.StudentViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val studentViewModel: StudentViewModel by viewModels<StudentViewModel>()

    // TODO - Talk about conversion of types with 'by'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding Setup
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Components/Widgets
        val btnShowToast = binding.btnShowToast
        val tvTextView = binding.tvStudentDetails

        // Initialize
        val myToast = Toast.makeText(applicationContext, "Hello world!", Toast.LENGTH_SHORT)
        val myOtherToast = Toast.makeText(applicationContext, "Second Toast!", Toast.LENGTH_LONG)

        // Listeners
        btnShowToast.setOnClickListener {
            myToast.show()
            myOtherToast.show()
            studentViewModel.setState()
        }

        // Snackbar.make(this, view, "", Snackbar.LENGTH_SHORT).show()

        // Setup Lifecycle
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                studentViewModel.studentUiState.collect {

                    // Update UI elements
                    tvTextView.text = studentViewModel.studentUiState.value.toString()
                }
            }
        }


    }
}