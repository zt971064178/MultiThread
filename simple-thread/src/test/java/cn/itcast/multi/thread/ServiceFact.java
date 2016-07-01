package cn.itcast.multi.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.itcast.multi.thread.facade.ExectueCallBack;

public class ServiceFact {
	public void testMultiThread() {
		/**
	     * 并行调度相关处理
	     * 
	     * 按卫星*日期 ，将待处理的任务分解为 卫星+日期 粒度的子任务 添加到paramMapList列表中
	     */
	    List<Map<String, Object>> paramMapList = new ArrayList<Map<String, Object>>();
	    for (Iterator<OrderParamSatellite> iterator = paramSatellites.iterator(); iterator.hasNext();) {
	      OrderParamSatellite paramSatellite = iterator.next();
	      
	      paramMapList.addAll(this.getParamMapList(paramSatellite));
	    }



	    //根据集群最大处理能力,分页处理任务列表，作为list截取的步长
	    
	    int fsize = HostServerQueue.getInstance().freeSize();
	    for(int i=0;i<paramMapList.size();i=i+fsize){
	      List<Map<String, Object>> tl = BXexample.getSubListPage(paramMapList, i,  fsize);
	      //并行调度
	      BXexample.BXfunction(tl,new ExectueCallBack(){
	              	public void doExectue(Object executor) throws Exception {
	              		ExecuteOrderBTask((Map<String, Object>)executor);
	              	}
	          });
	      
	      //动态查找空闲节点数量，即集群最大处理能力
	      fsize = HostServerQueue.getInstance().freeSize();
	    }
	}
}
