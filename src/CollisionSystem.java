import java.util.PriorityQueue;

public class CollisionSystem{
    private static final double HZ = 0.5;
    private final PriorityQueue<Event> pq;
    private double t = 0.0;
    private final Particle[] particles;

    public CollisionSystem(Particle [] particles){

    }
    public void simulate(){

    }
    private void predictCollisions(Particle particle, double limit){

    }
    private void redraw(){

    }

    private static class Event implements Comparable<Event> {
        private final double time;
        private final Particle A;
        private final Particle B;
        private final int countA;
        private final int countB;

        public Event(double time, Particle A, Particle B){

        }
        public boolean isValid(){

        }

        @Override
        public int compareTo(Event other){
            
        }
    }
}