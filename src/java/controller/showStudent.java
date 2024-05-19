package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(urlPatterns = {"/showStudent"})
public class showStudent extends HttpServlet {

    private static String line;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showStudent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getSpeech(request, response);

    }

    public static void getSpeech(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProcessBuilder pb = new ProcessBuilder("python", "C:\\Users\\Cuong\\Downloads\\New folder\\ProjectPy2\\test.py");
        Process p = pb.start();

        // Đọc output của script
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        String line2;
        StringBuilder output = new StringBuilder();
        while ((line2 = in.readLine()) != null) {
            output.append(line2).append("\n");
            // Gán giá trị của line2 cho line
            line = line2;
        }

        // Kiểm tra xem line có null không trước khi sử dụng
        if (line != null) {
            switch (line.trim().toLowerCase()) { // Trim và chuyển đổi line sang chữ thường để so sánh dễ dàng hơn
                case "new student":
                    RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "log out":
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("login.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "find a student":
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("searchStudent.jsp");
                    dispatcher3.forward(request, response);
                    break;
                default:
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */

                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet showStudent</title>");
                        out.println("<style>");
                        out.println("body {");
                        out.println("    background-color: #FFFFFF; /* Màu nền */");
                        out.println("    color: #51829B; /* Màu chữ */");
                        out.println("    font-family: Arial, sans-serif; /* Kiểu font */");
                        out.println("    margin: 0; /* Loại bỏ margin */");
                        out.println("    padding: 0; /* Loại bỏ padding */");
                        out.println("}");
                        out.println("h1 {");
                        out.println("    text-align: center; /* Căn giữa tiêu đề */");
                        out.println("    color: #51829B; /* Màu chữ */");
                        out.println("}");
                        out.println("button {");
                        out.println("    background-color: #FFFFFF; /* Màu nền nút */");
                        out.println("    color: #51829B; /* Màu chữ nút */");
                        out.println("    padding: 10px 20px; /* Kích thước padding */");
                        out.println("    border: none; /* Loại bỏ border */");
                        out.println("    border-radius: 5px; /* Bo tròn góc */");
                        out.println("    cursor: pointer; /* Đổi hình con trỏ khi di chuột */");
                        out.println("    display: block; /* Hiển thị dạng block */");
                        out.println("    margin: 0 auto; /* Căn giữa nút */");
                        out.println("}");
                        out.println("button:hover {");
                        out.println("    background-color: #51829B; /* Màu nền khi di chuột vào nút */");
                        out.println("    color: #FFFFFF; /* Màu chữ khi di chuột vào nút */");
                        out.println("}");
                        out.println("</style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1> Unknow Speech please reload page, your Speech is : " + line + "</h1>");
                        out.println("<button onclick=\"location.reload();\">Reload Page</button>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                    break;
            }
        } else {
            // Xử lý trường hợp line là null
            // Ví dụ: throw new ServletException("Giá trị của line là null");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
