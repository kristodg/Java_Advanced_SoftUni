package JavaAdvancedExam.kindergarten;

import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

    public class Kindergarten {
        private String name;
        private int capacity;
        private List<Child> registry;

        public Kindergarten(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
            this.registry = new ArrayList<Child>();
        }

        public boolean addChild(Child child) {
            if (registry.size() < capacity) {
                registry.add(child);
                return true;
            } else {
                return false;
            }
        }

        public boolean removeChild(String firstName) {
            for (Child child : registry) {
                if (child.getFirstName().equals(firstName)) {
                    registry.remove(child);
                    return true;
                }
            }
            return false;
        }

        public int getChildrenCount() {
            return registry.size();
        }

        public Child getChild(String firstName) {
            for (Child child : registry) {
                if (child.getFirstName().equals(firstName)) {
                    return child;
                }
            }
            return null;
        }

        public String registryReport() {
            StringBuilder report = new StringBuilder();
            report.append("Registered children in " + name + ":\n");
            Collections.sort(registry, new Comparator<Child>() {
                public int compare(Child c1, Child c2) {
                    if (c1.getAge() != c2.getAge()) {
                        return c1.getAge() - c2.getAge();
                    } else if (!c1.getFirstName().equals(c2.getFirstName())) {
                        return c1.getFirstName().compareTo(c2.getFirstName());
                    } else {
                        return c1.getLastName().compareTo(c2.getLastName());
                    }
                }
            });
            for (Child child : registry) {
                report.append("--\n" + child + "\n");
            }
            return report.toString();
        }
    }
