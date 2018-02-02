package org.academiadecodigo.bootcamp.tddmock;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SportsResultServiceTest {

    private SportsResultService sportsResults = new SportsResultService();
    private Client clientA = mock(Client.class);
    private Client clientB = mock(Client.class);
    private Sport sportA = mock(Sport.class);
    private Sport sportB = mock(Sport.class);
    private Sport sportC = mock(Sport.class);
    private Message message = mock(Message.class);
    LinkedList<Sport> sports = new LinkedList<Sport>();

    @Before
    public void setup() {
        sportsResults = new SportsResultService();
        clientA = mock(Client.class);
        clientB = mock(Client.class);
        message = mock(Message.class);
        sports.add(sportA);


    }

    @Test
    public void subscribedClientShouldReceiveMessage() {

        sportsResults.addSubscriber(clientA);
        sportsResults.send(message);

        verify(clientA).receive(message);


    }

    @Test
    public void messageShouldBeSendToAllSubscribedClients(){

        sportsResults.addSubscriber(clientA);
        sportsResults.addSubscriber(clientB);

        sportsResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);

    }

    @Test
    public void notSubscribedClientShouldNotReceiveMessage(){

        sportsResults.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void clientSubscribedTwiceShouldNotReceiveTwoMessagesOnlyOne(){
        sportsResults.addSubscriber(clientA);
        sportsResults.addSubscriber(clientA);

        sportsResults.send(message);

        verify(clientA,times(1)).receive(message);
    }



    @Test
    public void unsubscribedClientGaveUpAGoodSystemOfInformationSoNoMoreContentForThisPerson(){
        sportsResults.addSubscriber(clientA);

        sportsResults.remove(clientA);

        sportsResults.send(message);

        verify(clientA, never()).receive(message);
    }

    @Test
    public void doesSubscriptionGetAdded(){
        sportsResults.addSubscriber(clientA);
        sportsResults.addSubscription(clientA, sportA);
        assertEquals(sports, sportsResults.getSports(clientA));
    }



    @Test
    public void clientOnlyReceivesTheSubscribedToSports(){
        sportsResults.addSubscriber(clientA);

        //sportsResults.addSubscription(sportA);
        //sportsResults.addSubscription(sportB);

        sportsResults.send(message);

        verify(clientA,times(1)).receive(message);
    }


}
