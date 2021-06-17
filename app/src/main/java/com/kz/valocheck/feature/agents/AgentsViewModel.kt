package com.kz.valocheck.feature.agents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.repo.AgentsRepo
import com.kz.valocheck.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(private val agentsRepo: AgentsRepo) : ViewModel() {

    private  val _agentList = MutableLiveData<ViewState<List<AgentsDomain>>>()
    val agentList : LiveData<ViewState<List<AgentsDomain>>>
    get() = _agentList

    fun getAgentsList() {

        viewModelScope.launch {
            try {
                _agentList.value = ViewState.Loading
                _agentList.value = ViewState.Success(agentsRepo.getAgentsList().filterNot { it.developerName.contains("NPE") })
            } catch (e: Exception) {
                _agentList.value = ViewState.Error(e)
            }
        }

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