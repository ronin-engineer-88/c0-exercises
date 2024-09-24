package _10_Exception.homework.exercise_9;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Số dư tài khoản của bạn không đủ để rút " + amount + " VND.");
        }
        balance -= amount;
        System.out.println("Rút tiền thành công. Số dư còn lại của bạn là: " + balance);
    }
}

/*

Bài 9: Quản lý giao dịch với ngoại lệ
        Giả sử bạn đang viết một chương trình mô phỏng giao dịch ngân hàng.
        Viết một lớp BankAccount với phương thức withdraw(double amount) để rút tiền từ tài khoản.
        Nếu số tiền rút lớn hơn số dư tài khoản, ném ra ngoại lệ InsufficientFundsException.
        Sử dụng try-catch để xử lý giao dịch thất bại và hoàn tác giao dịch nếu cần thiết.

*/
