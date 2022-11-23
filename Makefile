run:
	javac -classpath bin -d bin src/*.java src/**/*.java
	cd bin && java Main