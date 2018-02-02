package org.academiadecodigo.bootcamp.tddmock;

import java.awt.List;
import java.util.*;

public class SportsResultService {

    private Collection<Client> clients = new HashSet<Client>();

    Map<Client , LinkedList<Sport>> clientLinkedListMap = new HashMap<Client, LinkedList<Sport>>();

    public void addSubscriber(Client client) {
        clients.add(client);
        LinkedList<Sport> sports = new LinkedList<Sport>();
        clientLinkedListMap.put(client, sports);

    }


    public void send(Message message) {

        for(Client client : clients) {

            client.receive(message);
        }


    }

    public void remove(Client client) {
        clients.remove(client);
    }

    public void addSubscription(Client client, Sport sport) {
        LinkedList<Sport> listsports = clientLinkedListMap.get(client);
        listsports.add(sport);
        clientLinkedListMap.put(client, listsports);

    }

    public LinkedList<Sport> getSports(Client client) {
        return new LinkedList<Sport>();
    }
}
