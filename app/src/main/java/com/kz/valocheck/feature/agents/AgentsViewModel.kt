package com.kz.valocheck.feature.agents

import android.util.Log
import androidx.lifecycle.*
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.repo.AgentsRepo
import com.kz.valocheck.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(private val agentsRepo: AgentsRepo) : ViewModel() {

    private  val _agentList = MutableLiveData<ViewState<List<AgentsDomain>>>()
    val agentList : LiveData<ViewState<List<AgentsDomain>>>
    get() = _agentList

    private fun getAgentsList() {

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




    val roleList : LiveData<List<String>> = agentsRepo.getRoleList().distinctUntilChanged().map {
        it.map {
            it.name
        }
    }





    var checkedRoleName : String? = null
    fun filter(roleName: String?) {

        if (roleName == checkedRoleName) {
            return
        }

        checkedRoleName = roleName

        viewModelScope.launch {

            try {
                if(roleName == null) {
                   _agentList.value  = ViewState.Success(agentsRepo.getAgentsList().filterNot { it.developerName.contains("NPE") })
                }else {
                    _agentList.value = ViewState.Success(agentsRepo.getRoleWithAgent(roleName))
                }
            } catch (e: Exception) {
                Log.e("Error", "Role Filter", e)
            }

        }
    }




    
}