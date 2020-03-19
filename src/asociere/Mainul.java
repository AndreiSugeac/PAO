package asociere;

public class Mainul {

    public static void main(String[] args) {
        Profesor profesorPrincipalMate = new Profesor("Popescu", 1);
        Profesor profesorSecundMate = new Profesor("Ionescu", 2);
        Profesor profesorInfo = new Profesor("Anghel", 3);
        Profesor profesorMateSiInfo = new Profesor("Petrescu", 4);
        Profesor profesorInfoSiMate = new Profesor("Andrei", 5);

        Departament departamentInfo = new Departament("info");
        departamentInfo.setProfesori(new Profesor[]{profesorInfo, profesorInfoSiMate, profesorMateSiInfo});
        Departament departamentMate = new Departament("mate");
        departamentMate.setProfesori(new Profesor[]{profesorPrincipalMate, profesorSecundMate, profesorInfoSiMate, profesorMateSiInfo});

        Universitate unibuc = new Universitate("UNIBUC", new Departament[]{departamentInfo, departamentMate});
        System.out.println(unibuc);

        departamentInfo = null;
        System.out.println(unibuc);

        System.out.println(departamentMate);
        departamentMate.getProfesori()[1] = null;
        System.out.println(departamentMate);
        System .out.println(profesorSecundMate);
    }
}
