/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.message;

import com.airhacks.chatREST.ChatLine;
import com.google.gson.Gson;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 *
 * @author nataliat
 */
@Path("messages")
public class MessageReceived {

    public long venitLunar = 0;
    public long sumaCredit = 0;

    @GET
    public String getMessage() {
        return "Hello";
    }

    @Path("getMessage2")
    @GET
    public String getMessage2() {
        return "Hello2";
    }

    //method for Dialog 3 - user asks for maximum value of a loan and sends monthly income
    // Compute P
    // ****available values: 
    // 1. monthly income
    @GET
    @Path("/getOffersForLoanInstallments/{venit_lunar}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getOffersForLoanInstallments(@PathParam("venit_lunar") double venitLunar) {

        System.out.println("****************getOffersForLoanInstallments");
        System.out.println("values: ");
        System.out.println(venitLunar);

        String messageOffer = "";
        double P;

        double V = venitLunar;
        //Assume maximum for A
        double A = venitLunar / 3;

        //Assume 6 months loan tenure
        int finalNoMonths = 6;

        System.out.println("Numarul de luni------");
        System.out.println(finalNoMonths);

        //annual interest rate divided by 12 for monthly interest rate
        double r = 0.00875;

        //Compute P
        //Offer 1: 6 months
        P = A * ((1 - Math.pow(1 + r, -finalNoMonths)) / r);

        //Offer 2: 1 year
        double P2 = A * ((1 - Math.pow(1 + r, -12)) / r);

        //Offer 3: 2 years
        double P3 = A * ((1 - Math.pow(1 + r, -24)) / r);
        
        //Offer 4: 5 years
        double P4 = A * ((1 - Math.pow(1 + r, -60)) / r);

        System.out.println("^^^^^^^^^^^^^ P ^^^^^^^^^^^^^^");
        System.out.println(P);

//        //Oferta 1 -- Increase number of months
//        ArrayList<Double> newOffer1 = checkEMIForMinNoMonths(P, finalNoMonths, r, V / 3);
//
//        //Oferta 2 -- Decrease loan amoun
//        ArrayList<Double> newOffer2 = checkEMIForMaxAcceptableVal(P, finalNoMonths, r, V / 3);
        messageOffer = "Avand in vedere situatia dumneavoastra financiara, va permiteti urmatoarele valori maxime pentru credit: " + "~1. Pe "
                + "o perioada de 6 luni cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P) + " RON."
                + "~2. Pe o perioada de 1 an cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P2) + " RON."
                + "~3. Pe o perioada de 2 ani cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P3) + " RON."
                + "~4. Pe o perioada de 5 ani cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P4) + " RON.";

        return messageOffer;
    }

    //method for Dialog 3 - user asks for maximum value of a loan and sends monthly income
    // Compute P
    // ****available values: 
    // 1. monthly income
    @GET
    @Path("/getOfferForMaximumLoan/{venit_lunar}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getOfferForMaximumLoan(@PathParam("venit_lunar") double venitLunar) {

        System.out.println("****************getOfferForMaximumLoan");
        System.out.println("values: ");
        System.out.println(venitLunar);

        String messageOffer = "";
        double P;

        double V = venitLunar;
        //Assume maximum for A
        double A = venitLunar / 3;

        //Assume 6 months loan tenure
        int finalNoMonths = 6;

        System.out.println("Numarul de luni------");
        System.out.println(finalNoMonths);

        //annual interest rate divided by 12 for monthly interest rate
        double r = 0.00875;

        //Compute P
        //Offer 1: 6 months
        P = A * ((1 - Math.pow(1 + r, -finalNoMonths)) / r);

        //Offer 2: 1 year
        double P2 = A * ((1 - Math.pow(1 + r, -12)) / r);

        //Offer 3: 2 years
        double P3 = A * ((1 - Math.pow(1 + r, -24)) / r);

        //Offer 4: 5 years
        double P4 = A * ((1 - Math.pow(1 + r, -60)) / r);

        System.out.println("^^^^^^^^^^^^^ P ^^^^^^^^^^^^^^");
        System.out.println(P);

//        //Oferta 1 -- Increase number of months
//        ArrayList<Double> newOffer1 = checkEMIForMinNoMonths(P, finalNoMonths, r, V / 3);
//
//        //Oferta 2 -- Decrease loan amoun
//        ArrayList<Double> newOffer2 = checkEMIForMaxAcceptableVal(P, finalNoMonths, r, V / 3);
        messageOffer = "Va propun urmatoarele oferte de credit pentru valoarea venitului dvs lunar de " + venitLunar + " RON:" + "~1. Pe "
                + "o perioada de 6 luni cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P) + " RON."
                + "~2. Pe o perioada de 1 an cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P2) + " RON."
                + "~3. Pe o perioada de 2 ani cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P3) + " RON."
                + "~4. Pe o perioada de 5 ani cu o rata de " + new DecimalFormat("#.##").format(A) + " RON echivalenta cu o treime din venit si o dobanda lunara de 0.00875%, valoarea maxima pe care o puteti obtine este de " + new DecimalFormat("#.##").format(P4) + " RON.";

        return messageOffer;
    }

    //method for Dialog 4 - user sends only the loan value and not the income
    // Compute A without knowing monthly income
    // ****available values: 
    // 1. loan value
    @GET
    @Path("/getOffersUnknownIncome/{valoare_credit}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getOffersUnknownIncome(@PathParam("valoare_credit") double valueLoan) {

        System.out.println("****************getOffersUnknownIncome");
        System.out.println("values: ");
        System.out.println(valueLoan);

        String messageOffer = "";
        //P is known
        double P = valueLoan;

        double V;
        double A;
        //Assume 6 months loan tenure
        int finalNoMonths = 6;

        System.out.println("Numarul de luni------");
        System.out.println(finalNoMonths);

        //annual interest rate divided by 12 for monthly interest rate
        double r = 0.00875;

        //Compute P
        //Offer 1: 6 months
        A = P * ((r * Math.pow(1 + r, finalNoMonths)) / (Math.pow(1 + r, finalNoMonths) - 1));
        //Minimum monthly income for the computed monthly interest spanning 6 months
        V = 3 * A;

        //Offer 2: 1 year
        double A2 = P * ((r * Math.pow(1 + r, 12)) / (Math.pow(1 + r, 12) - 1));
        //Minimum monthly income for the computed monthly interest spanning 12 months
        double V2 = 3 * A2;

        //Offer 3: 2 years
        double A3 = P * ((r * Math.pow(1 + r, 24)) / (Math.pow(1 + r, 24) - 1));
        //Minimum monthly income for the computed monthly interest spanning 24 months
        double V3 = 3 * A3;

        System.out.println("^^^^^^^^^^^^^ P ^^^^^^^^^^^^^^");
        System.out.println(P);

//        //Oferta 1 -- Increase number of months
//        ArrayList<Double> newOffer1 = checkEMIForMinNoMonths(P, finalNoMonths, r, V / 3);
//
//        //Oferta 2 -- Decrease loan amoun
//        ArrayList<Double> newOffer2 = checkEMIForMaxAcceptableVal(P, finalNoMonths, r, V / 3);
        messageOffer = "Va propun urmatoarele oferte pentru un credit de valoarea " + valueLoan + " RON:" + "~1. Pe "
                + "o perioada de 6 luni cu o rata de " + new DecimalFormat("#.##").format(A) + " RON si o dobanda lunara de 0.00875%, valoarea minima a venitului lunar este de " + new DecimalFormat("#.##").format(V) + " RON."
                + "~2. Pe o perioada de 1 an cu o rata de " + new DecimalFormat("#.##").format(A2) + " RON si o dobanda lunara de 0.00875%, valoarea minima a venitului lunar este de " + new DecimalFormat("#.##").format(V2) + " RON."
                + "~3. Pe o perioada de 2 ani cu o rata de " + new DecimalFormat("#.##").format(A3) + " RON si o dobanda lunara de 0.00875%, valoarea minima a venitului lunar este de " + new DecimalFormat("#.##").format(V3) + " RON.";

        return messageOffer;
    }

    //method for Dialog 1 - user sends loan value and monthly income
    // Compute A
    // ****available values: 
    // 1. monthly income
    // 2. value of the loan
    @GET
    @Path("/getOfferForSumaAndVenit2/{suma_credit}/{venit_lunar}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public String getOfferForSumaAndVenit2(@PathParam("suma_credit") double sumaCredit, @PathParam("venit_lunar") double venitLunar) {

        System.out.println("****************getOfferForSumaAndVenit2");
        System.out.println("values: ");
        System.out.println(sumaCredit);
        System.out.println(venitLunar);
        String messageOffer = "";
        double P = sumaCredit;

        double V = venitLunar;

        double constraint = V / 3;

        int realNoMonths = (int) P / (int) constraint;

        int finalNoMonths = 0;

        if (realNoMonths <= 6) {

            finalNoMonths = 6;

        } else if (realNoMonths <= 24) {
            finalNoMonths = realNoMonths;
        } else {
            finalNoMonths = 24;
        }
        System.out.println("Numarul de luni------");
        System.out.println(finalNoMonths);

        //annual interest rate divided by 12 for monthly interest rate
        double r = 0.00875;

        double A = P * ((r * Math.pow(1 + r, finalNoMonths)) / (Math.pow(1 + r, finalNoMonths) - 1));

        System.out.println("^^^^^^^^^^^^^ A ^^^^^^^^^^^^^^");
        System.out.println(A);

        if (A <= V / 3) {

            System.out.println("SE INCADREAZA");

            messageOffer = "Va propun: O rata lunara de " + new DecimalFormat("#.##").format(A) + " pe o durata de " + finalNoMonths + " luni cu o dobanda lunara de 0.0875%";
        } else {

            System.out.println("NU SE INCADREAZA");
            //Oferta 1 -- Increase number of months
            ArrayList<Double> newOffer1 = checkEMIForMinNoMonths(P, finalNoMonths, r, V / 3);

            //Oferta 2 -- Decrease loan amoun
            ArrayList<Double> newOffer2 = checkEMIForMaxAcceptableVal(P, finalNoMonths, r, V / 3);

            messageOffer = "Nu va incadrati. Rata lunara calculata in valoare de " + new DecimalFormat("#.##").format(A) + "RON pe 6 luni depaseste o treime din valoare venitului dumneavoastra lunar. Va propun urmatoarele oferte de credit:" + "~1. Pentru suma pe care ati cerut-o, pe "
                    + newOffer1.get(1) + " luni cu o rata de " + new DecimalFormat("#.##").format(newOffer1.get(0)) + " RON." + "~2. Pentru suma de " + newOffer2.get(1) + " RON pe " + finalNoMonths + " luni cu o rata de " + new DecimalFormat("#.##").format(newOffer2.get(0)) + " RON.";

        }

        return messageOffer;
    }

    public ArrayList<Double> checkEMIForMinNoMonths(double P, int noMonths, double r, double constraint) {

        double A = 0;

        System.out.println("checkEMIForMinNoMonths");

        ArrayList<Double> result = new ArrayList<>();

        boolean found = false;
        while (!found) {

            System.out.println("while---checkEMIForMinNoMonths");

            A = P * ((r * Math.pow(1 + r, noMonths)) / (Math.pow(1 + r, noMonths) - 1));

            if (A <= constraint) {
                found = true;
            } else {
                noMonths++;
            }
        }

        result.add((Double) A);
        result.add((double) noMonths);

        return result;

    }

    public ArrayList<Double> checkEMIForMaxAcceptableVal(double P, int noMonths, double r, double constraint) {

        double A = 0;

        System.out.println("checkEMIForMaxAcceptableVal");

        ArrayList<Double> result = new ArrayList<>();

        boolean found = false;
        while (!found) {

            System.out.println("while---checkEMIForMaxAcceptableVal");

            A = P * ((r * Math.pow(1 + r, noMonths)) / (Math.pow(1 + r, noMonths) - 1));

            if (A <= constraint) {
                found = true;
            } else {
                P -= 200;
            }
        }

        result.add((Double) A);
        result.add((Double) P);

        return result;

    }
    //TEST

    @GET
    @Path("/getOfferForSumaAndVenit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String getOfferForSumaAndVenit(String values) {
        System.out.println("****************getOfferForSumaAndVenit");
        System.out.println("values: ");
        System.out.println(values);

        Gson gs = new Gson();
        JSONObject jsonObj = new JSONObject(values);

        //ChatLine chatline = gs.fromJson(conversation, ChatLine.class);
        System.out.println("JSON-------------------------");
        System.out.println(jsonObj);

        String messageOffer = "";

        double P = (double) jsonObj.get("suma_credit");

        double V = (double) jsonObj.get("venit_lunar");

        double constraint = V / 3;

        int realNoMonths = (int) P / (int) constraint;

        int finalNoMonths = 0;

        if (realNoMonths <= 6) {

            finalNoMonths = 6;

        } else if (realNoMonths <= 24) {
            finalNoMonths = realNoMonths;
        }
        System.out.println("Numarul de luni------");
        System.out.println(finalNoMonths);

        //annual interest rate divided by 12 for monthly interest rate
        double r = 2.5;

        double A = P * ((r * Math.pow(1 + r, finalNoMonths)) / (Math.pow(1 + r, finalNoMonths) - 1));

        System.out.println("^^^^^^^^^^^^^ A ^^^^^^^^^^^^^^");
        System.out.println(A);

        if (A <= V / 3) {

            System.out.println("SE INCADREAZA");

            messageOffer = "Va propun: O rata lunara de " + new DecimalFormat("#.##").format(A) + " pe o durata de " + finalNoMonths + " cu o rata lunara de 2.5%";
        } else {
            messageOffer = "Nu va incadrati";
        }

        return messageOffer;
    }
}
