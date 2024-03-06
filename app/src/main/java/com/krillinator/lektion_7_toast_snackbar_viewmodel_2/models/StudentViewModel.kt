package com.krillinator.lektion_7_toast_snackbar_viewmodel_2.models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StudentViewModel : ViewModel() {

    /* Information
    *   MutableStateFlow == Kotlin's Coroutines (ASYNC)
    *   uiState datatype == StateFlow<StudentState>
    *   uiState = _uiState.asStateFlow
    * */

    /* TODO - Lambda repetition + COPY() with Data class */
    /* TODO - More than one object */

    private val _studentUiState = MutableStateFlow(StudentState("", 0))
    var studentUiState: StateFlow<StudentState> = _studentUiState.asStateFlow()

    fun setState() {

        _studentUiState.update {
            studentState -> studentState.copy(
                age = 5
            )
        }

    }

}