package automation.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CityManager implements RouteManager{

    private HashMap<String, String> forwardPath, backwardPath;
    private List<String> theRoute;

    public CityManager()
    {
        forwardPath = new HashMap<>();
        backwardPath = new HashMap<>();
    }

    public boolean connected(String city1, String city2)
    {
        List<String> forwardRoute = new ArrayList<>();
        List<String> backwardRoute = new ArrayList<>();
        theRoute = new ArrayList<>();
        boolean foundInForwardPath = false;
        boolean foundInBackwardPath = false;
        boolean continueSearchingForwardPath = true;
        boolean continueSearchingBackwardPath = true;
        String currentForwardKey = city1;
        String currentBackwardKey = city1;
        while(continueSearchingForwardPath)
        {
            if(forwardPath.containsKey(currentForwardKey))
            {
                if(forwardPath.get(currentForwardKey).equals(city2))
                {
                    forwardRoute.add(currentForwardKey);
                    forwardRoute.add(city2);
                    continueSearchingForwardPath = false;
                    foundInForwardPath = true;
                }
                else
                {
                    forwardRoute.add(currentForwardKey);
                    currentForwardKey = forwardPath.get(currentForwardKey);
                    continueSearchingForwardPath = true;
                }
            }
            else
            {
                continueSearchingForwardPath = false;
                foundInForwardPath = false;
            }
        }
        while(continueSearchingBackwardPath)
        {
            if(backwardPath.containsKey(currentBackwardKey))
            {
                if(backwardPath.get(currentBackwardKey).equals(city2))
                {
                    backwardRoute.add(currentBackwardKey);
                    backwardRoute.add(city2);
                    continueSearchingBackwardPath = false;
                    foundInBackwardPath = true;
                }
                else
                {
                    backwardRoute.add(currentBackwardKey);
                    currentBackwardKey = backwardPath.get(currentBackwardKey);
                    continueSearchingBackwardPath = true;
                }
            }
            else
            {
                continueSearchingBackwardPath = false;
                foundInBackwardPath = false;
            }
        }
        if(foundInForwardPath) { theRoute = forwardRoute; }
        if(foundInBackwardPath) { theRoute = backwardRoute; }
        return foundInForwardPath || foundInBackwardPath;
    }

    public List<String> getRoute(String city1, String city2)
    {
        connected(city1, city2);
        return theRoute;
    }

    public void addConnection(String city1, String city2)
    {
        forwardPath.put(city1, city2);
        backwardPath.put(city2, city1);
    }
}
