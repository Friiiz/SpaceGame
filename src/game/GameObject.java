package game;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public final class GameObject {

    public enum ComponentType {
        ANIMATION,
        COLLIDER,
        PLAYER_CONTROLLER,
        TRANSFORM
    }

    private Map<ComponentType, Component> components;
    
    public GameObject () {
        components = new LinkedHashMap<>();
    }

    public GameObject (Map<ComponentType, Component> components) {
        this.components = components;
    }
    
    public void update(double deltaTime) {
        //components.forEach(component -> component.update(deltaTime));
    }

    private Component getComponent(ComponentType key) {
        if(!components.containsKey(key)) throw new NoSuchElementException("This GameObject does not have a " + key);
        return components.get(key);
    }

    //TODO: implement method to automatically sort components according to importance?
}
