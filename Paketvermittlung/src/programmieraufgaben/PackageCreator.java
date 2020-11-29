package programmieraufgaben;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class PackageCreator {

    /**
     * Hier sollen die Kommandozeilen-Abfragen abgefragt und die Antworten
     * gespeichert werden
     * Es sollte auf Fehlerbehandlung geachtet werden (falsche Eingaben, ...)
     *
     * @param dataPackage Hier wird das Objekt übergeben in das die abgefragten Werte gespeichert werden sollen
     * @return Gibt das als Parameter übergebene Objekt, dass mit den abgefragten Werten befüllt wurde zurück
     */
    public DataPackage fillParameters(DataPackage dataPackage) {
    	System.out.println("Geben Sie eine Version ein");
    	Scanner version = new Scanner(System.in);
    	System.out.println("Geben Sie die Nachricht ein");
    	Scanner message = new Scanner(System.in);
    	dataPackage.setVersion(Integer.parseInt(version.nextLine()));
    	dataPackage.setMessage(message.nextLine());
        return dataPackage;
    }

    /**
     * Aus dem als Parameter übergebenen Paket sollen die Informationen
     * ausgelesen und in einzelne Datenpakete aufgeteilt werden
     *
     * @param dataPackage Hier wird das Objekt übergeben in das das Resultat gespeichert werden soll
     * @return Gibt das als Parameter übergebene Objekt mit den aufgeteiltet Datenpaketen zurück
     */
    public List<DataPackage> splitPackage(DataPackage dataPackage) {
        List<DataPackage> dataPackages = new LinkedList<>();
        int length = dataPackage.getDataPackageLength();
        String message = dataPackage.getMessage();
        message.trim();
        String[] messages = message.split(" ");
        for(int i = 0; i< messages.length;i++) {
    		DataPackage newDataPackage = new DataPackage(messages[i].length());
    		newDataPackage.setVersion(dataPackage.getVersion());
    		newDataPackage.setMessage(messages[i]);
    		dataPackages.add(i, newDataPackage);
        }
        return dataPackages;
    }

    /**
     * Diese Methode gibt den Inhalt der empfangenen Pakete in der Komandozeile aus
     *
     * @param dataPackages Hier wird die Liste übergeben, deren Elemente in die Kommandozeile ausgegeben werden sollen
     */
    public void printOutPackage(List<DataPackage> dataPackages) {    
    	System.out.println("Version "+ dataPackages.get(0).getVersion());
    	System.out.println("Aufteilung in "+ (dataPackages.size()) +" Pakete:");
    	for(int i = 0; i < dataPackages.size(); i++) {
    		System.out.println(dataPackages.get(i).getMessage());
    	}
    }
}
