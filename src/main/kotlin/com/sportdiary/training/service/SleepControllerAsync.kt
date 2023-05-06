package com.sportdiary.training.service

import mu.KLogger
import mu.KLogging
import mu.KotlinLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

 class SleepControllerAsync {

     companion object {
         val logger = KotlinLogging.logger {}
         fun getRandomNumber(min: Int, max: Long): Long {
             return (Math.random() * (max - min) + min).toLong()
         }

         @Async
         fun getSleepResult(countSec: Long): Future<String> {
             val sleepSec = getRandomNumber(1, countSec)
             TimeUnit.SECONDS.sleep(sleepSec);
             val result = "Sleep $sleepSec seconds"
             logger.info{ result}
             return AsyncResult<String>(result)
         }
     }


}