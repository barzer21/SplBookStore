package bgu.spl.mics;

import java.util.HashMap;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The {@link MessageBusImpl class is the implementation of the MessageBus interface.
 * Write your implementation here!
 * Only private fields and methods can be added to this class.
 */
public class MessageBusImpl implements MessageBus {

	ConcurrentHashMap<MicroService,ConcurrentLinkedQueue<Message>> microQueusHM;
	ConcurrentHashMap<Event,Vector<MicroService>> eventVectorHM;
	ConcurrentHashMap<Broadcast,Vector<MicroService>> broadcastVectorHM;

	private static MessageBusImpl instance=null;

	private  MessageBusImpl (){
		microQueusHM= new ConcurrentHashMap<MicroService,ConcurrentLinkedQueue<Message>>();
		eventVectorHM= new ConcurrentHashMap<Event,Vector<MicroService>>();
		broadcastVectorHM= new ConcurrentHashMap<Broadcast,Vector<MicroService>>();

	}

	public static MessageBusImpl getInstance(){
		if(instance==null)
			 instance=new MessageBusImpl();
		return instance;

	}
	@Override
	public <T> void subscribeEvent(Class<? extends Event<T>> type, MicroService m) {
		eventVectorHM.get(type).add(m);//subscribe the m to this event
	}

	@Override
	public void subscribeBroadcast(Class<? extends Broadcast> type, MicroService m) {
		broadcastVectorHM.get(type).add(m);

	}

	@Override
	public <T> void complete(Event<T> e, T result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendBroadcast(Broadcast b) {
		for(MicroService m: broadcastVectorHM.get(b)){
			microQueusHM.get(m).add(b);
		}

	}

	
	@Override
	public <T> Future<T> sendEvent(Event<T> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(MicroService m) {
		for()

	}

	@Override
	public void unregister(MicroService m) {
		// TODO Auto-generated method stub

	}

	@Override
	public Message awaitMessage(MicroService m) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
