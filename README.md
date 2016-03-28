# DEZSYS-07 "VERTEILTE OBJEKTE MIT CORBA"
## 1 Einführung
Verteilte Objekte haben bestimmte Grunderfordernisse, die mittels implementierten Middlewares leicht verwendet werden können. Das Verständnis hinter diesen Mechanismen ist aber notwendig, um funktionale Anforderungen entsprechend sicher und stabil implementieren zu können.

### 1.1 Ziele
Diese Übung gibt eine einfache Einführung in die Verwendung von verteilten Objekten mittels CORBA. Es wird speziell Augenmerk auf die Referenzverwaltung sowie Serialisierung von Objekten gelegt. Es soll dabei eine einfache verteilte Applikation in zwei unterschiedlichen Programmiersprachen implementiert werden.

### 1.2 Voraussetzungen
Grundlagen Java, C++ oder anderen objektorientierten Programmiersprachen
Grundlagen zu verteilten Systemen und Netzwerkverbindungen
Grundlegendes Verständnis von nebenläufigen Prozessen

### 1.3 Aufgabenstellung
Verwenden Sie das Paket ORBacus oder omniORB bzw. JacORB um Java und C++ ORB-Implementationen zum Laufen zu bringen.

Passen Sie eines der Demoprogramme (nicht Echo/HalloWelt) so an, dass Sie einen Namingservice verwenden, welches ein Objekt anbietet, das von jeweils einer anderen Sprache (Java/C++) verteilt angesprochen wird. Beachten Sie dabei, dass eine IDL-Implementierung vorhanden ist um die unterschiedlichen Sprachen abgleichen zu können.

Vorschlag: Verwenden Sie für die Implementierungsumgebung eine Linux-Distribution, da eine optionale Kompilierung einfacher zu konfigurieren ist.

## 2 Quellen
"omniORB : Free CORBA ORB"; Duncan Grisby; 28.09.2015; online: http://omniorb.sourceforge.net/

"Orbacus"; Micro Focus; online: https://www.microfocus.com/products/corba/orbacus/orbacus.aspx

"JacORB - The free Java implementation of the OMG's CORBA standard."; 03.11.2015; online: http://www.jacorb.org/

"The omniORB version 4.2 Users’ Guide"; Duncan Grisby; 11.03.2014; online: http://omniorb.sourceforge.net/omni42/omniORB.pdf

"CORBA/C++ Programming with ORBacus Student Workbook"; IONA Technologies, Inc.; September 2001; online: http://www.ing.iac.es/~docs/external/corba/book.pdf

*Bewertung*: 16 Punkte
- ORB-Anpassung in Ordnung und Verwendung korrekt (3 Punkte)
- Mindestens zwei unterschiedliche Programmiersprachen verwendet und IDL-Compiler korrekt angewandt (4 Punkte)
- IIOR über entweder Argument (1 Punkt) / File (3 Punkte) / Namingservice (4 Punkte) verteilt
- Deployment und einfache Tests vorhanden (2 Punkte)
- Protokoll entsprechend der Richtlinien mit entsprechendem theoretischen Background (3 Punkte)
