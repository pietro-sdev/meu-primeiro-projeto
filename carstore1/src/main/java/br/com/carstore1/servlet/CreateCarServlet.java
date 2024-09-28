package br.com.carstore1.servlet;

import br.com.carstore1.dao.CarDao;
import br.com.carstore1.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carName = req.getParameter("car-name");
        String carColor = req.getParameter("car-color");
        System.out.println(carName);
        System.out.println(carColor);

        Car car = new Car();
        car.setName(carName);
        car.setColor(carColor);
        CarDao cardao = new CarDao();

        cardao.createCar(car);

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
