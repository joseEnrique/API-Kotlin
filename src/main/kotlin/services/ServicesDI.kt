package services

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

fun DI.MainBuilder.bindServices(){
    bind<ServiceService>() with singleton { ServiceService() }
    bind<RequestService>() with singleton { RequestService() }
}