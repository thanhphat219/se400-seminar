package com.example.back_end.service

import com.example.back_end.entity.TimeOffRequestEntity
import com.example.back_end.entity.toModel
import com.example.back_end.model.TimeOffRequest
import com.example.back_end.repository.TimeOffRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.NullPointerException

@Service
class TimeOffServiceImpl(@Autowired private val timeOffRepository: TimeOffRepository): TimeOffService {
    override fun create(timeOffRequestEntity: TimeOffRequestEntity): String {
        try {
            val value = timeOffRepository.save(timeOffRequestEntity.toModel())
            return value.id ?: throw NullPointerException()
        } catch (e: Exception) {
            throw Exception(e)
        }
    }

}