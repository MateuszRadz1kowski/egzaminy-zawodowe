import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Button, Form, Container } from "react-bootstrap";

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
			isChecked ? "Hasło automatycznie generowane" : `Hasło: ${password}`,
		]);
	};

	return (
		<Container className="mt-4">
			<h1>Menedżer haseł - wykonał 0000000000</h1>

			<Form className="my-4">
				<Form.Group className="mb-3">
					<Form.Label>Adres WWW:</Form.Label>
					<Form.Control
						type="text"
						placeholder="Adres strony WWW"
						onChange={handlePocztaChange}
					/>
				</Form.Group>

				<Form.Group className="mb-3">
					<Form.Label>Login:</Form.Label>
					<Form.Control
						type="text"
						placeholder="Twój login"
						onChange={handleLoginChange}
					/>
				</Form.Group>

				<Form.Group className="mb-3">
					<Form.Check
						type="checkbox"
						label="Wygeneruj hasło"
						checked={isChecked}
						onChange={() => setIsChecked(!isChecked)}
					/>
				</Form.Group>

				<Form.Group className="mb-3">
					<Form.Label>Hasło:</Form.Label>
					<Form.Control
						type="password"
						disabled={isChecked}
						onChange={handlePasswordChange}
					/>
				</Form.Group>

				<Button variant="primary" onClick={handleAccountSave}>
					Zapisz
				</Button>
			</Form>

			{account.length > 0 && (
				<div className="mt-4">
					<p className="text-primary lead p-2 m-0">Adres: {account[0]}</p>
					<p className="p-2 m-0">Login: {account[1]}</p>
					<p className="p-2 m-0">{account[2]}</p>
				</div>
			)}
		</Container>
	);
}

export default App;
