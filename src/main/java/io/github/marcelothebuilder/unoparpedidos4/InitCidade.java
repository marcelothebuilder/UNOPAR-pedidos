//package io.github.marcelothebuilder.unoparpedidos4;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import io.github.marcelothebuilder.unoparpedidos4.service.DumbService;
//
//@Component
//@Transactional
//public class InitCidade {
//	@Autowired
//	private DumbService dumbService;
//
//	@EventListener(ContextRefreshedEvent.class)
//	@Transactional
//	private void onBoot(){
//		System.out.println(dumbService);
//		dumbService.onBoot();
//	}
//	
//}
