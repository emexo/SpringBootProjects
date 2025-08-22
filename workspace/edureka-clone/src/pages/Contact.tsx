export default function Contact() {
	return (
		<section className="container-responsive py-12">
			<h2 className="text-2xl font-semibold mb-4">Contact</h2>
			<form className="grid gap-3 max-w-xl">
				<input placeholder="Name" className="border rounded px-3 py-2" />
				<input placeholder="Email" type="email" className="border rounded px-3 py-2" />
				<textarea placeholder="Message" className="border rounded px-3 py-2" rows={4} />
				<button className="px-4 py-2 rounded bg-brand text-white w-fit">Send</button>
			</form>
		</section>
	)
}