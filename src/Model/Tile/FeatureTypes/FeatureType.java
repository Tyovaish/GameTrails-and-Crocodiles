package Model.Tile.FeatureTypes;

/**
 * Created by Trevor on 3/25/2017.
 */
public abstract class FeatureType {
        private String featureType;

        public void addType(String type){
            this.featureType = type;
        }


        public String getType(){
            return this.featureType;
        }

        public abstract Boolean isLand();
        public abstract Boolean riverEnd();
}
