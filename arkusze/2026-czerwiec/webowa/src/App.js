import logo from "./logo.svg";
import "./App.css";
import { Button, Card } from "react-bootstrap";
import { Form } from "react-bootstrap";
import { useState } from "react";

function App() {
  const [poczta, setPoczta] = useState("");
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [account, setAccount] = useState([]);
  const [isChecked, setIsChecked] = useState(true);

  const handlePocztaChange = (e) => {
    setPoczta(e.target.value);
  };

  const handleLoginChange = (e) => {
    setLogin(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleAccountSave = () => {
    setAccount([
      poczta,
      login,
      isChecked ? "hasło wygenerowane automatycznie" : password,
    ]);
  };

  return (
    <div className="App">
      <Card>
        <h1>Menadżer haseł - wykonał 0000000000</h1>

        <Form>
          <Form.Label>Adres WWW:</Form.Label>
          <Form.Control
            type="text"
            onChange={(e) => handlePocztaChange(e)}
          ></Form.Control>
          {/* podpiac tooltipa chyba */}
          <Form.Label>Login :</Form.Label>
          <Form.Control
            type="text"
            onChange={(e) => handleLoginChange(e)}
          ></Form.Control>

          <Form.Check
            onChange={() => setIsChecked(!isChecked)}
            checked={isChecked}
          ></Form.Check>
          <Form.Check.Label>Wygeneruj hasło</Form.Check.Label>
          <Form.Control
            disabled={isChecked}
            type="password"
            onChange={(e) => handlePasswordChange(e)}
          ></Form.Control>
        </Form>

        <Button onClick={handleAccountSave} color="blue" className="w-50">
          Zapisz
        </Button>

        <Card>
          <h1 className="text-primary padding-[0.5rem]">Adres: {account[0]}</h1>
          <h1 className="padding-[0.5rem]">Login: {account[1]}</h1>
          <h1 className="padding-[0.5rem]">Hasło: {account[2]}</h1>
        </Card>
      </Card>
    </div>
  );
}

export default App;
