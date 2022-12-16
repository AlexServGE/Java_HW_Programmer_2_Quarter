import java.util.*;

public class Notebook {
    public String notebookRAMgb;
    public String notebookHDDgb;
    public String notebookOS;
    public String notebookColor;
    public Map<String,String> allParameters = new HashMap<>();

    public Notebook(String notebookRAMgb, String notebookHDDgb, String notebookOS, String notebookColor) {
        this.notebookRAMgb = notebookRAMgb;
        this.notebookHDDgb = notebookHDDgb;
        this.notebookOS = notebookOS;
        this.notebookColor = notebookColor;
        this.allParameters.put("RAM", this.notebookRAMgb);
        this.allParameters.put("HDD", this.notebookHDDgb);
        this.allParameters.put("OS", this.notebookOS);
        this.allParameters.put("Color", this.notebookColor);

    }

    public Notebook() {
        Random rand = new Random();
        List<String> variationsRAM = new ArrayList<>(Arrays.asList("8", "16", "32", "64", "126"));
        List<String> variationsHDD = new ArrayList<>(Arrays.asList("100", "200", "300", "400", "500"));
        List<String> variationsOS = new ArrayList<>(Arrays.asList("Windows", "Linux", "MacOs", "DOS", "NoOS"));
        List<String> variationsColor = new ArrayList<>(Arrays.asList("Black", "Green", "Red", "Blue", "Ultramarine"));
        String randomRAM = variationsRAM.get(rand.nextInt(variationsRAM.size()));
        String randomHDD = variationsHDD.get(rand.nextInt(variationsHDD.size()));
        String randomOS = variationsOS.get(rand.nextInt(variationsOS.size()));
        String randomColor = variationsColor.get(rand.nextInt(variationsColor.size()));
        this.notebookRAMgb = randomRAM;
        this.notebookHDDgb = randomHDD;
        this.notebookOS = randomOS;
        this.notebookColor = randomColor;
        this.allParameters.put("RAM", this.notebookRAMgb);
        this.allParameters.put("HDD", this.notebookHDDgb);
        this.allParameters.put("OS", this.notebookOS);
        this.allParameters.put("Color", this.notebookColor);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "notebookRAMgb=" + notebookRAMgb +
                ", notebookHDDgb=" + notebookHDDgb +
                ", notebookOS='" + notebookOS + '\'' +
                ", notebookColor='" + notebookColor + '\'' +
                '}';
    }
}
