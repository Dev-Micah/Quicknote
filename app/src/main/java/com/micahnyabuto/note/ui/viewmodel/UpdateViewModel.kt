package com.micahnyabuto.note.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class UpdateViewModel: ViewModel() {
    private val note = MutableStateFlow(false)
}