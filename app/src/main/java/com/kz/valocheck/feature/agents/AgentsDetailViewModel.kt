package com.kz.valocheck.feature.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kz.valocheck.domain.AbilityDomain
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.repo.AgentsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsDetailViewModel @Inject constructor(private val agentsRepo: AgentsRepo): ViewModel() {


    private val _agentDetail = MutableLiveData<AgentsDomain>()
    val agentDetail : LiveData<AgentsDomain>
    get() = _agentDetail

    fun getAgentDetail(agentId: String) {
        viewModelScope.launch {
            _agentDetail.value = agentsRepo.getAgentDetails(agentId)
        }
    }


}