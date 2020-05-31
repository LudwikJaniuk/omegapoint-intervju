package validitychecker;

// Tänker att om vi ändå ska göra en klass för dem så kan de få ha möjligheten att vara stateful
// Fast egentligen är det inte en feature jag skulle vilja ha
// Men för mer avancerat skit, typ om de ska hålla i en uppkoppling eller så, då kan det behövas
interface ValidityCheck<T> {
	public String checkAndReturnNullOrError(T input);
	public String name();
}
