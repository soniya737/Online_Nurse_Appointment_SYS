all: compile execute

compile:
	mvn compile

execute:
	java @spring_boot.argfile com.soniyad30.online_nurse_appointment.OnlineNurseAppointmentApplication

clean:
	rm -r target/classes/com/soniyad30/online_nurse_appointment/*