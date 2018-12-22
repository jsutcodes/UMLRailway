package io.github.jsutcodes.util.UML;

public class ClassRelationship {

        public final String x;
        public final String y;

        public ClassRelationship(String x, String y) {

            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof ClassRelationship) {
                ClassRelationship objTuple = (ClassRelationship)o;
                return (objTuple.x.equals(this.x) && objTuple.y.equals(this.y));
            }
            else {
                return this.equals(o);
            }
        }

        @Override
        public String toString() {
           return String.format("{\"relationshipTo\": \"%s\", \"relationshipType\":\"%s\"}",x,y);
        }

}
