package com.kz.valocheck.feature.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.repo.AgentsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(private val agentsRepo: AgentsRepo) : ViewModel() {

    private  val _agentList = MutableLiveData<List<AgentsDomain>>()

    val agentList : LiveData<List<AgentsDomain>>
    get() = _agentList

    fun getAgentsList() {
        _agentList.value = agentsRepo.getAgentsList()
    }

    init {
        getAgentsList()
    }

    private val _navigateToAgentsData = MutableLiveData<String?>()
    val navigateToAgentsData : LiveData<String?>
    get() = _navigateToAgentsData

    fun onAgentsClicked(agentId : String) {
        _navigateToAgentsData.value = agentId
    }

    fun onAgentsDataNavigated() {
        _navigateToAgentsData.value = null
    }

}