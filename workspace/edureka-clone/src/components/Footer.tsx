export default function Footer() {
	return (
		<footer className="border-t py-8 mt-12">
			<div className="container-responsive text-sm text-slate-600 flex flex-col md:flex-row gap-4 md:items-center md:justify-between">
				<div>© {new Date().getFullYear()} Edureka Clone</div>
				<div className="flex gap-4 text-slate-500">
					<a href="#" className="hover:text-brand">Terms</a>
					<a href="#" className="hover:text-brand">Privacy</a>
					<a href="#" className="hover:text-brand">Support</a>
				</div>
			</div>
		</footer>
	)
}