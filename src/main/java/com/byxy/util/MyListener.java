package com.byxy.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 自定义监听器
 * @author Mrc
 *
 */
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(" ......................我佛慈悲......................");
		System.out.println("                       _oo0oo_                      ");
		System.out.println("                      o8888888o                     ");
		System.out.println("                      88\" . \"88                     ");
		System.out.println("                      (| -_- |)                     ");
		System.out.println("                      0\\  =  /0                     ");
		System.out.println("                    ___/‘---’\\___                   ");
		System.out.println("                  .' \\|       |/ '.                 ");
		System.out.println("                 / \\\\|||  :  |||// \\                ");
		System.out.println("                / _||||| -卍-|||||_ \\               ");
		System.out.println("               |   | \\\\\\  -  /// |   |              ");
		System.out.println("               | \\_|  ''\\---/''  |_/ |              ");
		System.out.println("               \\  .-\\__  '-'  ___/-. /              ");
		System.out.println("             ___'. .'  /--.--\\  '. .'___            ");
		System.out.println("          .\"\" ‘<  ‘.___\\_<|>_/___.’ >’ \"\".          ");
		System.out.println("         | | :  ‘- \\‘.;‘\\ _ /’;.’/ - ’ : | |        ");
		System.out.println("         \\  \\ ‘_.   \\_ __\\ /__ _/   .-’ /  /        ");
		System.out.println("     =====‘-.____‘.___ \\_____/___.-’___.-’=====     ");
		System.out.println("                       ‘=---=’                      ");
		System.out.println("                                                    ");
		System.out.println("....................佛祖开光 ,永无BUG...................");
	}

}
